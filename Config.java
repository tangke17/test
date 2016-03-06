package loco.sdkInterface.global;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Config {
	private static Logger LOG = Logger.getLogger(Config.class);
	public boolean isSSL;
	public String ip;
	public int port ;	
	public int num_buf ;
	public int bufsize;
	//public int maxBufSize;
	public int maxReqSize;	
	public int httpMaxContentLength;
	
	//write queue
	public int write_savetime;
	public int num_wirte_thread;
	
	//read queue
	public int num_read_queue ;
	public int num_readThread;
	
	//kafka
	public String kafka_ip_port ;
	public String kafka_topic ;
	public int kafka_retrynum ;
	public int kafka_MAX_REQUEST_SIZE_CONFIG;
	public String kafka_TIMEOUT;
	public String kafka_ACKS_CONFIG;
	public String kafka_BUFFER_MEMORY_CONFIG;
	
	//RSA
	public int RSA_isON;
	public int RSA_isLoadKeyFromFile;
	private String RSA_publickey_FilePath;
	private String RSA_privatekey_FilePath;
	
	//error queue
	public int isSaveError;
	public int num_error_queue;
	public int num_errorThread;	
	public String errorSaveFile_prefix;
	public String errorSeparator;
	
	
	public final int error = 1;
	public final int success = 0;
	
	
	public Config(String[] args) throws Exception{
		if(args.length != 2 || (!"-c".equals(args[0]) && !"-conf".equals(args[0])) ){
			printInfo();
			throw new Exception("args is not correct");
		}		
		
		String confPath = args[1];
		Properties props = new Properties();
		//try {
			InputStream in = new BufferedInputStream (new FileInputStream(confPath));
			props.load(in);
			ip = 				   props.getProperty("ip");
			port =                 Integer.valueOf(props.getProperty("port"));			
			num_buf =              Integer.valueOf(props.getProperty("num_buf"));
			bufsize=               Integer.valueOf(props.getProperty("bufsize"));									
			maxReqSize = 		   Integer.valueOf(props.getProperty("maxReqSize"));			
			httpMaxContentLength = Integer.valueOf(props.getProperty("httpMaxContentLength"));
			
			//write queue
			num_wirte_thread =     Integer.valueOf(props.getProperty("num_wirte_thread"));						
			write_savetime =       Integer.valueOf(props.getProperty("write_savetime"));
			
			//kafka
			kafka_retrynum =       Integer.valueOf(props.getProperty("kafka_retrynum"));
			kafka_ip_port =        props.getProperty("kafka_ip_port");
			kafka_topic =                props.getProperty("kafka_topic");
			kafka_MAX_REQUEST_SIZE_CONFIG = Integer.valueOf(props.getProperty("kafka_MAX_REQUEST_SIZE_CONFIG"));
			kafka_TIMEOUT =        props.getProperty("kafka_TIMEOUT");
			kafka_ACKS_CONFIG  =   props.getProperty("kafka_ACKS_CONFIG");
			kafka_BUFFER_MEMORY_CONFIG = props.getProperty("kafka_BUFFER_MEMORY_CONFIG");
			
			//RSA
			RSA_isON             = Integer.valueOf(props.getProperty("RSA_isON"));
			RSA_isLoadKeyFromFile = Integer.valueOf(props.getProperty("RSA_isLoadKeyFromFile"));
			RSA_publickey_FilePath = props.getProperty("RSA_publickey_FilePath");
			RSA_privatekey_FilePath = props.getProperty("RSA_privatekey_FilePath");
			
			//read queue
			num_read_queue =       Integer.valueOf(props.getProperty("num_read_queue"));
			num_readThread =       Integer.valueOf(props.getProperty("num_readThread"));
			
			//error queue
			num_error_queue =      Integer.valueOf(props.getProperty("num_error_queue"));
			num_errorThread = Integer.valueOf(props.getProperty("num_errorThread"));			
			isSaveError =       Integer.valueOf(props.getProperty("isSaveError"));			
			errorSaveFile_prefix = props.getProperty("errorSaveFile_prefix");
			errorSeparator = props.getProperty("errorSeparator");
					
			int issl = Integer.valueOf(props.getProperty("isSSL"));
			if(issl == 1){
				isSSL = true;
			}else if(issl == 0){
				isSSL = false;
			}else{
				LOG.error("values of isSSL is not correct");
				throw new Exception("values of isSSL is not correct");
			}
			
			if(num_read_queue*num_readThread > num_buf){
				LOG.error("error, num_read_queue*num_readThread > num_buf,break");
				throw new Exception("error, num_read_queue*num_readThread > num_buf,break");
			}
			
			if(maxReqSize > bufsize){
				LOG.error("error,maxReqSize > bufsize,break");
				throw new Exception("error,maxReqSize > bufsize,break");
			}
			
			/*} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new Exception(e.getMessage());
		}*/
	}	
	
	public void printInfo(){
		System.out.println("useage: -conf confPath");
	}

	public String getRSA_publickey_FilePath() {
		return RSA_publickey_FilePath;
	}

	public void setRSA_publickey_FilePath(String rSA_publickey_FilePath) {
		RSA_publickey_FilePath = rSA_publickey_FilePath;
		LOG.info("public key path changed:"+rSA_publickey_FilePath);
	}

	public String getRSA_privatekey_FilePath() {
		return RSA_privatekey_FilePath;
	}

	public void setRSA_privatekey_FilePath(String rSA_privatekey_FilePath) {
		RSA_privatekey_FilePath = rSA_privatekey_FilePath;
		LOG.info("private key path changed:"+rSA_privatekey_FilePath);
	}
	
	
}
