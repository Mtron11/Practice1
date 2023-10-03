import org.example.RegularJava;
import org.junit.Assert;
import org.junit.Test;

public class RegularJavaTests {
    RegularJava RJ = new RegularJava();

    @Test
    public void testCorrectIP1(){
        String ip = "56.0.0.1";
        Assert.assertEquals(true, RJ.correctIP(ip));
    }

    @Test
    public void testCorrectIP2(){
        String ip = "255.255.255.255";
        Assert.assertEquals(true, RJ.correctIP(ip));
    }
    @Test
    public void testCorrectIP3() {
        String ip = "0.0.0.0";
        Assert.assertEquals(true,  RJ.correctIP(ip));
    }

    @Test
    public void testCorrectIPWithMore256() {
        String ip= "255.255.255.256";
        Assert.assertEquals(false,  RJ.correctIP(ip));
    }

    @Test
    public void testCorrectIPWithLessOctets() {
        String ip= "255.255.255";
        Assert.assertEquals(false,  RJ.correctIP(ip));
    }

    @Test
    public void testIsIPAddressWithEmptyOctet() {
        String ip= "255.255..253";
        Assert.assertEquals(false,  RJ.correctIP(ip));
    }

    @Test
    public void testCorrectGuid1() {
        String guid = "e02fd0e4-00fd-090A-ca30-0d00a0038ba0";
        Assert.assertEquals(true, RJ.correctGuid(guid));
    }

    @Test
    public void testCorrectGuid2() {
        String guid = "53DE358F-45F1-E311-93EA-00269E58F20D";
        Assert.assertEquals(true, RJ.correctGuid(guid));
    }

    @Test
    public void testCorrectGuid3() {
        String guid = "d1fb1489-6f0e-abcd-e2f4-1bac20fd2a22";
        Assert.assertEquals(true, RJ.correctGuid(guid));
    }

    @Test
    public void testCorrectGuidWithMoreSymbols() {
        String guid = "e02fd0e4-00fd-090A-ca30-0d00a0038ba40";
        Assert.assertEquals(false, RJ.correctGuid(guid));
    }

    @Test
    public void testCorrectGuidWithIncorrectSymbols() {
        String guid = "e02fd0e4-00fd-090A-ca30-0d00a0u38ba40";
        Assert.assertEquals(false, RJ.correctGuid(guid));
    }

    @Test
    public void testCorrectGuidWithNotHyphen() {
        String guid = "e02fd0e4-00fd-090A+ca30-0d00a0u38ba40";
        Assert.assertEquals(false, RJ.correctGuid(guid));
    }

    @Test
    public void testCorrectURL1(){
        String url = "http://www.example.com";
        Assert.assertEquals(true, RJ.correctURL(url));
    }

    @Test
    public void testCorrectURL2(){
        String url = "https://vk.com/im?peers=c132_251336404&sel=207082627";
        Assert.assertEquals(true, RJ.correctURL(url));
    }

    @Test
    public void testCorrectURL2JustText() {
        String url = "Поставьте зачет";
        Assert.assertEquals(false, RJ.correctURL(url));
    }

    @Test
    public void testCorrectURL2WithNoAdress() {
        String url = "www.com";
        Assert.assertEquals(false, RJ.correctURL(url));
    }

    @Test
    public void testCorrectURL2WithHyphenInDomen() {
        String url = "https://vyatsu-my.sharepoint.com/:w:/g/personal/usr11801_vyatsu_ru/EXSYtF-6KNRDlEt2XQHy7l4Bn_9G93sIl9hHFDpsubQLIg?wdOrigin=TEAMS-ELECTRON.p2p.bim&wdExp=TEAMS-CONTROL&wdhostclicktime=1694969850949&web=1";
        Assert.assertEquals(false, RJ.correctURL(url));
    }

    @Test
    public void testIsStrongPasswordWithNotDigit() {
        String weakPassword = "Cool_pass";

        Assert.assertEquals(false, RJ.strongPassword(weakPassword));
    }

    @Test
    public void testIsStrongPasswordWithNotUpperCase() {
        String weakPassword = "ool_pass345";

        Assert.assertEquals(false, RJ.strongPassword(weakPassword));
    }

    @Test
    public void testIsStrongPasswordWithNotLowerCase() {
        String weakPassword = "JKLJDGLGJ3333";

        Assert.assertEquals(false, RJ.strongPassword(weakPassword));
    }

    @Test
    public void testIsStrongPasswordTrue() {
        String strongPassword = "C00l_Pass";

        Assert.assertEquals(true, RJ.strongPassword(strongPassword));
    }

    @Test
    public void testIsStrongPasswordTrue2() {
        String strongPassword = "SupperPas1";

        Assert.assertEquals(true, RJ.strongPassword(strongPassword));
    }

    @Test
    public void testIsStrongPasswordTrue3() {
        String strongPassword = "lsdfg3aGGdljJJJJ";

        Assert.assertEquals(true, RJ.strongPassword(strongPassword));
    }

}
