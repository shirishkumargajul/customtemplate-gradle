package com.geni.services;

import java.io.InputStream;
import java.util.Properties;

import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.beans.StorageARI;

public class PrePopulateService {
	public static Properties prop;
	public static InputStream is; 
	
	private static final String appKind_commonApp = "Web Application";
	private static final String appKind_dataIntensiveApp = "Data Intensive";
	private static final String appKind_missionCriticalApp = "Mission-critical";
	private static final String appKind_streamingApp = "Live/Streaming Application";
	private static final String appKind_virtualDesktop = "Virtual Desktop";
	
	private static final String appPriority_performance = "High Performance";
	private static final String appPriority_availability = "High Availability";
	private static final String appPriority_throughput = "High Throughput";

	public static final NetworkARI getNetworkReq(GeneralARI general) {
		
		NetworkARI network;
		String appKind = general.getAppKind();
		String appPriority = general.getAppPriority();

		if (appKind.equals(appKind_commonApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				network.setBandwidth("10-20 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_performance)) {
				network.setBandwidth("10-20 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_throughput)) {
				network.setBandwidth("20-50 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			}
		} else if (appKind.equals(appKind_dataIntensiveApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Private IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_performance)) {
				network.setBandwidth("20-50 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Private IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_throughput)) {
				network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			}
		} else if (appKind.equals(appKind_missionCriticalApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_performance)) {
				network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_throughput)) {
				network.setBandwidth("10 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l2");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("SDN");
			}
		} else if (appKind.equals(appKind_streamingApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_performance)) {
				network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l2");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_throughput)) {
				network.setBandwidth("10 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Public IP");
				network.setNfv("No");
				network.setNetworkType("SDN");
			}
		} else if (appKind.equals(appKind_virtualDesktop)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Private IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_performance)) {
				network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Private IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			} else if (appPriority.equals(appPriority_throughput)) {
				network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setIsolated("No");
				network.setLayer("l3");
				network.setIp("Private IP");
				network.setNfv("No");
				network.setNetworkType("Wired Connection");
			}
		} else {
			network = null;
		}
		return network;

	}
	
	public static final StorageARI getStorageReq(GeneralARI general) {
		StorageARI storage;
		String appKind = general.getAppKind();
		String appPriority = general.getAppPriority();

		if (appKind.equals(appKind_commonApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				storage.setLocalStorageSize("5GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_performance)) {
				storage.setLocalStorageSize("5GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_throughput)) {
				storage.setLocalStorageSize("5GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			}
		} else if (appKind.equals(appKind_dataIntensiveApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				storage.setLocalStorageSize("10GB - 20GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_performance)) {
				storage.setLocalStorageSize("5GB - 10GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_throughput)) {
				storage.setLocalStorageSize("5GB - 10GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			}
		} else if (appKind.equals(appKind_missionCriticalApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				storage.setLocalStorageSize("100GB - 250GB");
				storage.setLocalStorageDisk("SSD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_performance)) {
				storage.setLocalStorageSize("50GB - 100GB");
				storage.setLocalStorageDisk("SSD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_throughput)) {
				storage.setLocalStorageSize("50GB - 100GB");
				storage.setLocalStorageDisk("SSD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			}
		} else if (appKind.equals(appKind_streamingApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				storage.setLocalStorageSize("500GB - 1TB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_performance)) {
				storage.setLocalStorageSize("250GB - 500GB");
				storage.setLocalStorageDisk("SSD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_throughput)) {
				storage.setLocalStorageSize("250GB - 500GB");
				storage.setLocalStorageDisk("SSD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			}
		} else if (appKind.equals(appKind_virtualDesktop)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				storage.setLocalStorageSize("5GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("Yes");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_performance)) {
				storage.setLocalStorageSize("5GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			} else if (appPriority.equals(appPriority_throughput)) {
				storage.setLocalStorageSize("5GB");
				storage.setLocalStorageDisk("HDD");
				storage.setRemoteStorage("No");
				storage.setRemoteStorageSize("null");
				storage.setRemoteStorageDisk("null");
				storage.setRemoteStorageLocation("null");
			}
		} else {
			storage = null;
		}
		return storage;

	}
	
	public static final ComputationARI getComputationReq(GeneralARI general) {
		ComputationARI computation;
		String appKind = general.getAppKind();
		String appPriority = general.getAppPriority();

		if (appKind.equals(appKind_commonApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setNoOfNodes("2");
				computation.setNoOfCores("2");
				computation.setDedicatedServer("No");
				computation.setRamSize("1GB - 2GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("3");
				computation.setDedicatedServer("No");
				computation.setRamSize("2GB - 4GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("2");
				computation.setDedicatedServer("No");
				computation.setRamSize("1GB - 2GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_dataIntensiveApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setNoOfNodes("4");
				computation.setNoOfCores("4");
				computation.setDedicatedServer("No");
				computation.setRamSize("4GB - 8GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setNoOfNodes("3");
				computation.setNoOfCores("4");
				computation.setDedicatedServer("No");
				computation.setRamSize("8GB - 12GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setNoOfNodes("3");
				computation.setNoOfCores("4");
				computation.setDedicatedServer("No");
				computation.setRamSize("4GB - 8GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_missionCriticalApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setNoOfNodes("2");
				computation.setNoOfCores("8");
				computation.setDedicatedServer("Yes");
				computation.setRamSize("16GB - 32GB");
				computation.setOperatingSystem("Cent OS 7");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setNoOfNodes("2");
				computation.setNoOfCores("10");
				computation.setDedicatedServer("Yes");
				computation.setRamSize("64GB - 128GB");
				computation.setOperatingSystem("Cent OS 7");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("10");
				computation.setDedicatedServer("Yes");
				computation.setRamSize("32GB - 64GB");
				computation.setOperatingSystem("Cent OS 7");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_streamingApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setNoOfNodes("2");
				computation.setNoOfCores("6");
				computation.setDedicatedServer("No");
				computation.setRamSize("16GB - 32GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("8");
				computation.setDedicatedServer("No");
				computation.setRamSize("32GB - 64GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("Yes");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("6");
				computation.setDedicatedServer("No");
				computation.setRamSize("16GB - 32GB");
				computation.setOperatingSystem("Ubuntu 14");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_virtualDesktop)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setNoOfNodes("2");
				computation.setNoOfCores("4");
				computation.setDedicatedServer("No");
				computation.setRamSize("4GB - 8GB");
				computation.setOperatingSystem("Windows Server 7");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("8");
				computation.setDedicatedServer("No");
				computation.setRamSize("16GB - 32GB");
				computation.setOperatingSystem("Windows Server 7");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("Yes");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setNoOfNodes("1");
				computation.setNoOfCores("4");
				computation.setDedicatedServer("No");
				computation.setRamSize("4GB - 8GB");
				computation.setOperatingSystem("Windows Server 7");
				computation.setOsArchitecture("64 bit");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else {
			computation = null;
		}
		return computation;

	}
}
