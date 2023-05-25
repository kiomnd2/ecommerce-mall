package kr.ziz.ecommercemall.interfaces.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ziz.ecommercemall.application.member.MemberFacade;
import kr.ziz.ecommercemall.common.response.CommonResponse;
import kr.ziz.ecommercemall.domain.member.MemberInfo;
import kr.ziz.ecommercemall.domain.member.fixture.MemberFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockBean(JpaMetamodelMappingContext.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(MemberApiController.class)
class MemberApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private MemberFacade memberFacade;

    @Test
    void memberJoin_test() throws Exception {

        MemberDto.RequestJoin joinDto = MemberFixture.createJoinDto();

        MemberInfo memberInfo = MemberInfo.builder()
                .member(MemberFixture.createMember())
                .build();

        given(memberFacade.registerMember(any())).willReturn(memberInfo);

        mockMvc.perform(post("/api/v1/member/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(joinDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(CommonResponse.Result.SUCCESS.name()))
                .andExpect(jsonPath("data.memberToken").isNotEmpty());
    }

    @Test
    void memberLogin_test() throws Exception {

        MemberDto.RequestLogin loginDto = MemberFixture.createLoginDto();

        MemberInfo memberInfo = MemberInfo.builder()
                .member(MemberFixture.createMember())
                .build();

        given(memberFacade.loginMember(any())).willReturn(memberInfo);

        mockMvc.perform(post("/api/v1/member/logged-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(loginDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(CommonResponse.Result.SUCCESS.name()))
                .andExpect(jsonPath("data.memberToken").isNotEmpty());
    }

    @Test
    void memberModify_test() throws Exception {

        MemberDto.RequestUpdate loginDto = MemberFixture.createUpdateDto();

        MemberInfo memberInfo = MemberInfo.builder()
                .member(MemberFixture.createMember())
                .build();

        given(memberFacade.updateMember(anyString(), any()))
                .willReturn(memberInfo);

        mockMvc.perform(put("/api/v1/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(loginDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(CommonResponse.Result.SUCCESS.name()))
                .andExpect(jsonPath("data.memberToken").isNotEmpty());
    }

    @Test
    void memberDelete_test() throws Exception {

        MemberDto.RequestToken requestToken = MemberFixture.createRequestToken();


        mockMvc.perform(delete("/api/v1/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(requestToken)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(CommonResponse.Result.SUCCESS.name()))
                .andExpect(jsonPath("data").value("삭제되었습니다."));
    }





}