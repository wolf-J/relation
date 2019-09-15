/**
 * 
 */
package wolf_j.com.github.relation.web.biz.service;

import wolf_j.com.github.relation.web.biz.service.bean.UserFromFrontEnd;
import wolf_j.com.github.relation.web.biz.service.bean.RegisterMessage;

/**
 * @author wolf-J
 *
 */

public interface RegisterService {

	RegisterMessage signUpUser(UserFromFrontEnd userVOFromFrontEnd);

}
