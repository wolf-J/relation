/**
 * 
 */
package wolf_j.com.github.relation.biz.service;

import wolf_j.com.github.relation.repository.entity.UserMessageEntity;

import java.util.List;

/**
 * @author wolf-J
 *
 */
public interface RelationListService {

	List<UserMessageEntity> getClosePersons(Integer pageIndex);

}
