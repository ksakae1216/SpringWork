package jp.org.web.login.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.org.web.login.entity.MloginUser;
import jp.org.web.login.service.data.LoginUser;

/**
 * UserDetailsServiceの実装クラス
 * Spring Securityでのユーザー認証に使用する
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String login_id) throws UsernameNotFoundException {

        // 認証を行うユーザー情報を格納する
        MloginUser user = null;
        try {
            // 入力したユーザーIDから認証を行うユーザー情報を取得する
            // 処理内容は省略
        	user = new MloginUser();
        	user.setLoginUserId("loginId");
        	user.setPassword("password");
        } catch (Exception e) {
            // 取得時にExceptionが発生した場合
            throw new UsernameNotFoundException("It can not be acquired User");
        }

        // ユーザー情報を取得できなかった場合
//        if(user == null){
//            throw new UsernameNotFoundException("User not found for login id: " + login_id);
//        }

        // ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
        return new LoginUser(user);
    }
	
}
