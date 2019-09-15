/**
 * 
 */
package wolf_j.com.github.relation.web.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wolf_j.com.github.relation.web.repository.entity.UserMessageEntity;
import wolf_j.com.github.relation.web.repository.entity.UserMessageRepository;

import static org.junit.Assert.assertEquals;

/**
 * @author wolf-J
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDBEncoding {
	@Autowired
	UserMessageRepository userMessageRepository;

	@Test
	public void testDBEncoding() {
		
		
		UserMessageEntity entity = new UserMessageEntity("wolf_1", "黄", null, null, null, null, null, null);
		userMessageRepository.save(entity);
		
		assertEquals("黄", userMessageRepository.findByUserName("wolf_1").getFullName());
		userMessageRepository.delete(entity);
	}

}