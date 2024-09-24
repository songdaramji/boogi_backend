package com.boogionandon.backend.domain;

import com.boogionandon.backend.domain.enums.MemberType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="d_type")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Member extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 40, unique = true, nullable = false)
  private String email;

  @Column(length = 70, nullable = false)
  private String password;

  @Column(length = 30, nullable = false)
  private String name;

  @Column(length = 20, nullable = false)
  private String phone;

  @Column(length = 100)
  private String address;

  @Column(length = 150)
  private String addressDetail;

  // 관리자인지 아닌지 결정하는 필드
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private MemberType memberType;
// 최상위로 이걸 두고 아래에 관리자와 관리자 아닌것들로 (아닌것들은 Role로 구분??)

// 추가로 필요한 필드가 있다면 추가

  private boolean delFlag = false;
}

