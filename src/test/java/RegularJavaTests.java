import org.example.RegularJava;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.management.ConstructorParameters;

public class RegularJavaTests {
    RegularJava RJ = new RegularJava();

    @ParameterizedTest
    @CsvSource({
            "56.0.0.1, true",
            "255.255.255.255, true",
            "0.0.0.0, true",
            "255.255.255.256, false",
            "255.255.255, false",
            "255.255..253, false"
    })
    public void testCorrectIP(String ip, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.correctIP(ip));
    }

    @ParameterizedTest
    @CsvSource({
            "e02fd0e4-00fd-090A-ca30-0d00a0038ba0, true",
            "53DE358F-45F1-E311-93EA-00269E58F20D, true",
            "d1fb1489-6f0e-abcd-e2f4-1bac20fd2a22, true",
            "e02fd0e4-00fd-090A-ca30-0d00a0038ba40, false",
            "e02fd0e4-00fd-090A-ca30-0d00a0u38ba40, false",
            "e02fd0e4-00fd-090A+ca30-0d00a0u38ba40, false"
    })
    public void testCorrectGuid(String guid, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.correctGuid(guid));
    }

    @ParameterizedTest
    @CsvSource({
            "http://www.example.com, true",
            "https://vk.com/im?peers=c132_251336404&sel=207082627, true",
            "Поставьте зачет, false",
            "www.com, false",
            "https://vyatsu-my.sharepoint.com/:w:/g/personal/usr11801_vyatsu_ru/EXSYtF-6KNRDlEt2XQHy7l4Bn_9G93sIl9hHFDpsubQLIg?wdOrigin=TEAMS-ELECTRON.p2p.bim&wdExp=TEAMS-CONTROL&wdhostclicktime=1694969850949&web=1, false"
    })
    public void testCorrectURL(String url, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.correctURL(url));
    }

    @ParameterizedTest
    @CsvSource({
            "Cool_pass, false",
            "ool_pass345, false",
            "JKLJDGLGJ3333, false",
            "C00l_Pass, true",
            "SupperPas1, true",
            "lsdfg3aGGdljJJJJ, true"
    })
    public void testStrongPassword(String password, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.strongPassword(password));
    }

}
