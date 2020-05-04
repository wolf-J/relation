/**
 *
 */
package wolf_j.com.github.relation.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wolf_j.com.github.relation.biz.service.RelationListService;
import wolf_j.com.github.relation.repository.entity.UserMessageEntity;
import wolf_j.com.github.relation.repository.entity.UserMessageRepository;

import java.util.List;

/**
 * @author wolf-J
 *
 */

@Service
public class RelationListServiceImpl implements RelationListService {

    private static final int PAGE_SIZE = 10;
    @Autowired
    UserMessageRepository userMessageRepository;

    @Override
    public List<UserMessageEntity> getClosePersons(Integer pageIndex) {
        Page<UserMessageEntity> closePersonsPage;
        if (pageIndex == null)
            pageIndex = 0;
        if (pageIndex < 0)
            closePersonsPage = userMessageRepository.findAll(PageRequest.of(pageIndex, PAGE_SIZE, Sort.Direction.DESC, "id"));
        closePersonsPage = userMessageRepository.findAll(PageRequest.of(pageIndex, PAGE_SIZE, Sort.Direction.ASC, "id"));
        return closePersonsPage.getContent();
    }

}