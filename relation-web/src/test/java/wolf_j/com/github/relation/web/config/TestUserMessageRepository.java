/**
 * 
 */
package wolf_j.com.github.relation.web.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import wolf_j.com.github.relation.web.repository.entity.UserMessageEntity;
import wolf_j.com.github.relation.web.repository.entity.UserMessageRepository;

/**
 * @author wolf-J
 *
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestUserMessageRepository {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	UserMessageRepository userMessageRepository;

	@Test
	public void testUserMessageRepositoryInsertedUserMessageSuccess() {

		UserMessageEntity userMessageEntity = new UserMessageEntity("一三", "黄", null, null, null, null, null, null);
		userMessageRepository.save(userMessageEntity);

		UserMessageEntity actualUserMessageEntity = userMessageRepository.findById(1L).get();
		Page<UserMessageEntity> userMessagePages = userMessageRepository.findByLikeUserName("一",
				PageRequest.of(0, 10, Sort.Direction.ASC, "id"));

		assertEquals(userMessageEntity, actualUserMessageEntity);
		assertEquals("黄", actualUserMessageEntity.getFullName());
		assertThat(userMessagePages.getContent().get(0)).isEqualTo(userMessageEntity);
	}

}
