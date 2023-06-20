package fr.associationrdj.backend.back.auth;


import org.springframework.security.core.GrantedAuthority;

import javax.management.relation.Role;

public enum Roles {

    ROLE_SUPERADMIN(new GrantedAuthority() {
        @Override
        public String getAuthority() {
            return "ROLE_SUPERADMIN";
        }
    }),
    ROLE_ADMIN(new GrantedAuthority() {
        @Override
        public String getAuthority() {
            return "ROLE_ADMIN";
        }
    }),
    ROLE_ADHERENT(new GrantedAuthority() {
        @Override
        public String getAuthority() {
            return "ROLE-ADHERENT";
        }
    }),
    ROLE_MEMBRE(new GrantedAuthority() {
        @Override
        public String getAuthority() {
            return "ROLE_MEMBRE";
        }
    });

    public final GrantedAuthority grantedAuthority;

    private Roles (GrantedAuthority grantedAuthority){
        this.grantedAuthority = grantedAuthority;
    }

}
