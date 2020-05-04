/**
 * 
 */
package wolf_j.com.github.relation.web.config;

import static org.junit.Assert.*;

import org.junit.Test;
import wolf_j.com.github.relation.repository.entity.UserMessageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wolf
 *
 */
public class TestUserMessageEntity {

	/**
	 * Test method for
	 * {@link UserMessageEntity#validateBirthDay()}.
	 */
	@Test
	public void testValidateBirthDay() {
		UserMessageEntity userMessageEntity = new UserMessageEntity();
		
		userMessageEntity.setBirthDay("2018-04-05");
		assertTrue(userMessageEntity.validateBirthDay());
		
		userMessageEntity.setBirthDay("2018-13-05");
		assertFalse(userMessageEntity.validateBirthDay());
		
		userMessageEntity.setBirthDay("2018-11-2");
		assertFalse(userMessageEntity.validateBirthDay());
		
		userMessageEntity.setBirthDay("2018-11-02");
		assertTrue(userMessageEntity.validateBirthDay());
		List<String> list = new ArrayList<String>(16);
	}

}
