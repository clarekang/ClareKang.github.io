package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
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

    // 양방향 연관관계 에서 무한루프 방지
    public void setSiteCode(SiteCode siteCode) {
        this.siteCode = siteCode;
        if (!this.siteCode.getAuthorities().contains(this)) {
            this.siteCode.getAuthorities().add(this);
        }
    }
}
