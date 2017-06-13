package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Data
@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_no")
    private Long authorityNo;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "site_code_no")
    private SiteCode siteCode;

    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "authority_code")
    private String authorityCode;

    @Column(name = "has_privacy")
    private String hasPrivacy;

    @Column(name = "view_name")
    private String viewName;

    @Column(name = "view_uri")
    private String viewUri;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_uri")
    private String resourceUri;

    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.REMOVE)
    private List<User> users;

    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.REMOVE)
    private List<Group> groups;

    public void setSiteCode(SiteCode siteCode) {
        this.siteCode = siteCode;
        if (this.siteCode.getAuthorities() != null && !this.siteCode.getAuthorities().contains(this)) {
            this.siteCode.getAuthorities().add(this);
        }
    }
}
