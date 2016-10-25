package com.geni.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.geni.beans.ApplicationRI;
import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.opensymphony.xwork2.ActionContext;

public class CustomTemplateService {
	
	public File createTemplate(ApplicationRI appRI) {
		return buildTemplate(appRI);
	}
	
	public String deployResources(ApplicationRI appRI) {
		ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/python2.7", "/Users/arjun_ac/Desktop/geni_deployment.py", Integer.toString(appRI.getGeneralARI().getNoOfNodes()));
		pb.redirectErrorStream(true);
		System.out.println("Running the deployment script");
		try {
			Process process = pb.start();
			/*File f = new File("/Users/arjun_ac/Desktop/");
			pb.directory(f);*/
			int errCode = process.waitFor();
			System.out.println("Echo command executed, any errors?" + (errCode == 0 ? "No" : "Yes"));
			String output = output(process.getInputStream());
			System.out.println("Echo output:\n" + output);
			
			//ServletActionContext.getResponse().getWriter().print(output);
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("pythonResult", output);
			//return output(process.getInputStream());
			return output;
		} catch (IOException e) {
			e.printStackTrace();
			return "python script error";
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "python script error";
		}
	}
	
	private String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}
	
	public File buildTemplate(ApplicationRI appRI) {
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try {
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Node mainRootElement = doc.createElementNS("http://crunchify.com/CrunchifyCreateXMLDOM", "customTemplate");
			doc.appendChild(mainRootElement);

			// append child elements to root element
			mainRootElement.appendChild(getTemplateId(doc,"temp_12345"));
			mainRootElement.appendChild(getAppInfo(doc, appRI.getGeneral()));
			//mainRootElement.appendChild(getHardwareResource(doc, appRI.getNetwork(), appRI.getStorage(), appRI.getComputation()));
			mainRootElement.appendChild(getSoftwareResource(doc));

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			File xmlFile = new File("/Users/arjun_ac/Desktop/CT_sample.xml");
			StreamResult file = new StreamResult(xmlFile);
			transformer.transform(source, file);

			System.out.println("\nXML DOM Created Successfully..");
			
			return xmlFile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Node getTemplateId(Document doc, String tempID) {
		Node node = doc.createElement("template_id");
        node.appendChild(doc.createTextNode(tempID));
        return node;
	}
	
	public static Node getAppInfo(Document doc, GeneralARI general) {
		Node rootNode = doc.createElement("application_info");
		
		Node child1 = doc.createElement("appName");
		child1.appendChild(doc.createTextNode(general.getAppName()));
		
		Node child2 = doc.createElement("appKind");
		child2.appendChild(doc.createTextNode(general.getAppKind()));
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		
		return rootNode;
	}
	
/*	public static Node getHardwareResource(Document doc, NetworkARI network, StorageARI storage, ComputationARI computation) {
		Node rootNode = doc.createElement("hardware_resources");
		
		rootNode.appendChild(getNetwork(doc, network));
		rootNode.appendChild(getStorage(doc, storage));
		rootNode.appendChild(getComputation(doc, computation));
		
		return rootNode;
	}*/
	
	public static Node getNetwork(Document doc, NetworkARI network) {
		Node rootNode = doc.createElement("network_resources");
		
		Node child1 = doc.createElement("bandwidth");
		child1.appendChild(doc.createTextNode(network.getBandwidth()));
		
		Node child2 = doc.createElement("layer");
		child2.appendChild(doc.createTextNode(network.getLayer()));
		
		Node child3 = doc.createElement("nfv");
		child3.appendChild(doc.createTextNode(network.getNfv()));
		
		Node child4 = doc.createElement("networkType");
		child4.appendChild(doc.createTextNode(network.getNetworkType()));
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
		rootNode.appendChild(child4);
		
		return rootNode;
	}
	
/*	public static Node getStorage(Document doc, StorageARI storage) {
		Node rootNode = doc.createElement("storage_resources");
		
		Node child1 = doc.createElement("storageSize");
		child1.appendChild(doc.createTextNode(storage.getStorageSize()));
		
		Node child2 = doc.createElement("storageType");
		child2.appendChild(doc.createTextNode(storage.getStorageType()));
		
		Node child3 = doc.createElement("storageLocation");
		child3.appendChild(doc.createTextNode(storage.getStorageLocation()));
		
		Node child4 = doc.createElement("storageDisk");
		child4.appendChild(doc.createTextNode(storage.getStorageDisk()));
		
		Node child5 = doc.createElement("storageBackup");
		child5.appendChild(doc.createTextNode(storage.getStorageBackup()));
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
		rootNode.appendChild(child4);
		rootNode.appendChild(child5);
		
		return rootNode;
	}*/
	
	public static Node getComputation(Document doc, ComputationARI computation) {
		Node rootNode = doc.createElement("computation_resources");
		
		Node child1 = doc.createElement("noOfVmInstances");
		child1.appendChild(doc.createTextNode(""+computation.getNoOfCores()));
		
		Node child2 = doc.createElement("operatingSystem");
		child2.appendChild(doc.createTextNode(computation.getOperatingSystem()));
		
		Node child3 = doc.createElement("ramSize");
		child3.appendChild(doc.createTextNode(computation.getRamSize()));
		
		Node child4 = doc.createElement("gpu");
		child4.appendChild(doc.createTextNode(computation.getGpuSize()));
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
		rootNode.appendChild(child4);
		
		return rootNode;
	}
	
	public static Node getSoftwareResource(Document doc) {
		Node node = doc.createElement("software_resources");
		return node;
	}
}
