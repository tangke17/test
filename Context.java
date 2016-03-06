package loco.sdkInterface.global;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.concurrent.LinkedBlockingQueue;
import io.netty.buffer.ByteBuf;
import loco.sdkInterface.processflow.ErrorFlow;

public class Context {
	private Config conf;
	private LinkedBlockingQueue<ByteBuf> qNullBuf ;
	private LinkedBlockingQueue<ByteBuf> qWriteBuf ;
	private LinkedBlockingQueue<ByteBuf> qdiskBuf ;
	public ErrorFlow ef;
	public final String PRIVATE_KEY_BASE64 =
            "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIqQL9vZ+Mh1Lxq0Z5f9w4/xhZ4T\n" +
                    "Kl4acHUgJql1ZqOhQYZdZuXfjXSBmimZxds32KYyY02zsj0qw4omPpvs/M/j+nvh1rnmRqG3SXrf\n" +
                    "rTeIpqd0cDDs95NakeEneXXa0C2+2IqmkeqhjggkO6c4IeMHV+mYKQRf0lD5re8WXX/nAgMBAAEC\n" +
                    "gYAstefrfgMr07w2Vr4SqjyfRuTBpBeIs+lTseMnzQ0ogZEeJSddx2viiytOfyL74KJUxm+KlBBQ\n" +
                    "cmsUOdD8CVVt2VcH63naa835YEVojqdj3X05IZk72LbH7eoaDDr9gL3DCOs7BdCWCJyLv93AzaZJ\n" +
                    "zLpu3d7kKEvKlL8La/SvkQJBAM+ouGIRYDD89JbZgKUnCbyHSd3VFfKOluc5/Fn4CcT8vhbrQgmA\n" +
                    "pb8rTCs7TkC4Ya66u+zB+If5CkUOe5GkjmkCQQCq0cEk+wplQIKSc6v58+k+eORgL6ld0JdiKjgi\n" +
                    "dpEMHSmtM6et6Ukhi+CWZ/oEK6O20WhOWUHqzpOCi8PponHPAkA3293FW4ExjEnK7jUBt++RjB7d\n" +
                    "kj02Iw8Kofl0xhjyqT4E8kGwRq/PLblug6R4GmEEXGzCsibFhMMzckLhGY/JAkBy4yySYL23J9Iq\n" +
                    "Cd5K+H+RYuHGx4eT721Bur+SfkhD64FSWoGWeGaVR2y//CKtl2Q+20zaFTI+aL3ReYtEodsFAkEA\n" +
                    "ooGmtWsgxDSThLn2l+gYhfZLy+hrewTWc3rvfd59Vmdvw+06d4PFM6mlwE8SJPON2uFfaztwoOFy\n" +
                    "eoxJEeDeow==";
	
	
	public final String PUBLIC_KEY_BASE64 =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKkC/b2fjIdS8atGeX/cOP8YWeEypeGnB1ICap\n" +
                    "dWajoUGGXWbl3410gZopmcXbN9imMmNNs7I9KsOKJj6b7PzP4/p74da55kaht0l63603iKandHAw\n" +
                    "7PeTWpHhJ3l12tAtvtiKppHqoY4IJDunOCHjB1fpmCkEX9JQ+a3vFl1/5wIDAQAB";
	
	public PublicKey publickey;
	public PrivateKey privatekey;
	
	public Context(String[] args) throws Exception {
		conf = new Config(args);
		qNullBuf = new LinkedBlockingQueue<ByteBuf>(); //null queuen for req msg
		qWriteBuf = new LinkedBlockingQueue<ByteBuf>(); //wirte queue for req msg
		qdiskBuf = new LinkedBlockingQueue<ByteBuf>(); //save error msg 
	}

	public Config getConf() {
		return conf;
	}

	public LinkedBlockingQueue<ByteBuf> getqNullBuf() {
		return qNullBuf;
	}


	public void setqNullBuf(LinkedBlockingQueue<ByteBuf> qNullBuf) {
		this.qNullBuf = qNullBuf;
	}


	public LinkedBlockingQueue<ByteBuf> getqWriteBuf() {
		return qWriteBuf;
	}


	public void setqWriteBuf(LinkedBlockingQueue<ByteBuf> qWriteBuf) {
		this.qWriteBuf = qWriteBuf;
	}


	public LinkedBlockingQueue<ByteBuf> getQdiskBuf() {
		return qdiskBuf;
	}


	public void setQdiskBuf(LinkedBlockingQueue<ByteBuf> qdiskBuf) {
		this.qdiskBuf = qdiskBuf;
	}	

	
}
