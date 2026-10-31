public class PublicTest {
    public static void main(String[] args) {
        if (!"Acl".equals(AccessLabel.label())) {
            throw new AssertionError("label");
        }
        if (!"java.security.acl".equals(AccessLabel.family())) {
            throw new AssertionError("family");
        }
        System.out.println("public ok");
    }
}
