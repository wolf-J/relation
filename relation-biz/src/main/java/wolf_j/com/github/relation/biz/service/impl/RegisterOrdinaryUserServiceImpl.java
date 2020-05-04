package wolf_j.com.github.relation.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wolf_j.com.github.relation.biz.service.RegisterService;
import wolf_j.com.github.relation.biz.service.bean.RegisterMessage;
import wolf_j.com.github.relation.biz.service.bean.UserFromFrontEnd;
import wolf_j.com.github.relation.repository.entity.UserEntity;
import wolf_j.com.github.relation.repository.entity.UserMessageEntity;
import wolf_j.com.github.relation.repository.entity.UserMessageRepository;
import wolf_j.com.github.relation.repository.entity.UserRepository;

/**
 * @author wolf-J
 */

@Service("registerOrdinaryUserServiceImpl")
public class RegisterOrdinaryUserServiceImpl implements RegisterService {

    private static final String ROLE = "ROLE_USER";
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMessageRepository userMessageRepository;

    @Override
    @Transactional
    public RegisterMessage signUpUser(UserFromFrontEnd userFromFrontEnd) {
        RegisterMessage registerMessage = new RegisterMessage();
        if (!validateUserMessage(userFromFrontEnd)) {
            registerMessage.setError(true);
            return registerMessage;
        }
        String password = new BCryptPasswordEncoder().encode(userFromFrontEnd.getPassword());
        UserEntity user = new UserEntity(userFromFrontEnd.getUsername(), password, ROLE);
        UserMessageEntity userMessage = userFromFrontEnd.toUserMessageEntity();
        if (isExistsUser(user))
            registerMessage.setFail(true);
        else {
            saveUserAndInfo(user, userMessage);
            registerMessage.setSuccess(true);
        }
        return registerMessage;
    }

    private boolean validateUserMessage(UserFromFrontEnd userFromFrontEnd) {
        return userFromFrontEnd.getUsername().matches("\\w{6,20}")
                && userFromFrontEnd.getPassword().matches("\\w{6,20}");
    }

    private boolean isExistsUser(UserEntity user) {
        return userRepository.findByUserName(user.getUsername()) == null ? false : true;
    }

    private void saveUserAndInfo(UserEntity user, UserMessageEntity userMessage) {
        userRepository.save(user);
        userMessageRepository.save(userMessage);
    }

}
