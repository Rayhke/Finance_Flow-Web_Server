package HandlingTest;

import com.example.Web.controller.dto.MemberDTO;
import com.example.Web.repository.DataBaseTcpRepository;

public class TestClient {
    public static void main(String[] args) {
        DataBaseTcpRepository tcp = new DataBaseTcpRepository();

        MemberDTO member = new MemberDTO(
                "nink2458", "1234asdf", "nink2458@naver.com"
        );

        tcp.send(member);
    }
}
