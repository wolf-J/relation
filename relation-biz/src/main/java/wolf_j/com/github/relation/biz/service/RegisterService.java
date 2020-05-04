/**
 * 
 */
package wolf_j.com.github.relation.biz.service;

import wolf_j.com.github.relation.biz.service.bean.UserFromFrontEnd;
import wolf_j.com.github.relation.biz.service.bean.RegisterMessage;

/**
 * @author wolf-J
 *
 */

public interface RegisterService {

	RegisterMessage signUpUser(UserFromFrontEnd userVOFromFrontEnd);

}
