import org.junit.Test;

import com.dsib.inter.JobWebServiceClient;

public class BB {

	//public void test(){
	public static void main(String[] args) {
		JobWebServiceClient client = new JobWebServiceClient();
		client.claim();
	}
}
