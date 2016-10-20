package org.bbz.shirostudy.chapter2.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by liulaoye on 16-10-20.
 * 自定义Realm实现
 */
public class MyRealm2 implements Realm{
    @Override
    public String getName(){
        return "myRealm2";

    }

    @Override
    public boolean supports( AuthenticationToken authenticationToken ){
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo( AuthenticationToken token ) throws AuthenticationException{
        final String name = (String) token.getPrincipal();
        final String password = new String( (char[]) token.getCredentials());

        if( !"liulaoye".equals( name ) ) {
            throw new UnknownAccountException(  );
        }
        if( !"liulaoye".equals( password ) ) {
            throw new IncorrectCredentialsException(  );
        }

        return new SimpleAuthenticationInfo( name,password,getName() );
    }
}
