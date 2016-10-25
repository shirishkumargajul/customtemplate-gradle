package com.geni.actions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessBuilderDemo extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String pythonScript() {
		ProcessBuilder pb = new ProcessBuilder("python", "/Users/arjun_ac/Desktop/geni_deployment.py", "name", "arjun", "age", "23");
		//ProcessBuilder slkj = new Proce
		System.out.println("Running the deployment script");
		try {
			Process process = pb.start();
			/*File f = new File("/Users/arjun_ac/Desktop/");
			pb.directory(f);*/
			int errCode = process.waitFor();
			System.out.println("Echo command executed, any errors?" + (errCode == 0 ? "No" : "Yes"));
			//System.out.println("Echo output:\n" + output(process.getInputStream()));
			String output = output(process.getInputStream());
			ServletActionContext.getResponse().getWriter().print(output);
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("pythonResult", output);
			//return output(process.getInputStream());
			return null;
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
}
