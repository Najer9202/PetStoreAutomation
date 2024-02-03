package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.converters.IntegerConverter;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtest {
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testpostUser(String userID,String userName,String fname,String lname,String useremail,String pdw,String ph)
	{
		User userPayload= new User();
		//userPayload.setId(userID);
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pdw);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.CreateUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void deleteUserByName(String userName) 
	{
		Response response=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
