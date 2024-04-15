package HandlingTest;

import com.example.Web.controller.dto.UserDTO;
import com.example.Web.repository.DataBaseTcpRepository;

public class TestClient {
    public static void main(String[] args) {
        DataBaseTcpRepository tcp = new DataBaseTcpRepository();

        UserDTO member = new UserDTO(
                "nink2458", "1234asdf", "nink2458@naver.com"
        );

        tcp.send(member);
    }
}
