package sberleasing.api.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;

@Jacksonized
@Builder
@AllArgsConstructor
@Data
public class UserDto {
  public Long id;
  public String username;
  public String firstName;
  public String lastName;
  public String email;
  public String password;
  public String phone;
  public Integer userStatus;

}
