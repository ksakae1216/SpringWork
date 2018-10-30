package jp.org.web.login.service.data;

import java.util.List;


import org.springframework.security.core.authority.AuthorityUtils;

import jp.org.web.login.entity.MloginUser;

/**
 * 認証ユーザーの情報を格納するクラス
 */
public class LoginUser extends org.springframework.security.core.userdetails.User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * ログインユーザー
     */
    private final MloginUser mLoginUser;
    /**
     * その他、ログイン後に利用したい情報があればここで宣言する
     */

    /**
     * コンストラクタ
     * @param user
     */
    public LoginUser(MloginUser user) {
        // スーパークラスのユーザーID、パスワードに値をセットする
        // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
        super(user.getLoginUserId(), user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.mLoginUser = user;
    }

    /**
     *
     * @return
     */
    public MloginUser getUser() {
        return mLoginUser;
    }
	
}
