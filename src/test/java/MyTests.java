import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    
    @Test
    public void testEncryptCaesar() {
        // Uppercase, basic
        assertEquals("KHOOR", Caesar.encryptCaesar("HELLO"), "The encrypted output of \"HELLO\" should be: " + "KHOOR");
        assertEquals("KHOOR ZRUOG", Caesar.encryptCaesar("HELLO WORLD"), "The encrypted output of \"HELLO WORLD\" should be: " + "KHOOR ZRUOG");
        assertEquals("KHOOR, ZRUOG!", Caesar.encryptCaesar("HELLO, WORLD!"), "The encrypted output of \"HELLO, WORLD!\" should be: " + "KHOOR, ZRUOG!");

        // Lowercase, basic
        assertEquals("khoor", Caesar.encryptCaesar("hello"), "The encrypted output of \"hello\" should be: " + "khoor");
        assertEquals("khoor zruog", Caesar.encryptCaesar("hello world"), "The encrypted output of \"hello world\" should be: " + "khoor zruog");
        assertEquals("khoor, zruog!", Caesar.encryptCaesar("hello, world!"), "The encrypted output of \"hello, world!\" should be: " + "khoor, zruog!");

        // XYZ
        assertEquals("cheud a-udbv", Caesar.encryptCaesar("zebra x-rays"), "The encrypted output of \"zebra x-rays\" should be: " + "cheud a-udbv");
        assertEquals("FRQWHAWXDOLCH BDNV", Caesar.encryptCaesar("CONTEXTUALIZE YAKS"), "The encrypted output of \"CONTEXTUALIZE YAKS\" should be: " + "FRQWHAWXDOLCH BDNV");
        assertEquals("defghijklmnopqrstuvwxyzabc", Caesar.encryptCaesar("abcdefghijklmnopqrstuvwxyz"), "The encrypted output of \"abcdefghijklmnopqrstuvwxyz\" should be: " + "defghijklmnopqrstuvwxyzabc");
        assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC", Caesar.encryptCaesar("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), "The encrypted output of \"ABCDEFGHIJKLMNOPQRSTUVWXYZ\" should be: " + "DEFGHIJKLMNOPQRSTUVWXYZABC");
        assertEquals("deFGhIJklmNOPQRstuVWxyZAbC", Caesar.encryptCaesar("abCDeFGhijKLMNOpqrSTuvWXyZ"), "The encrypted output of \"abCDeFGhijKLMNOpqrSTuvWXyZ\" should be: " + "deFGhIJklmNOPQRstuVWxyZAbC");
    }

    @Test
    public void testDecryptCaesar() {
        // Uppercase, basic
        assertEquals("HELLO", Caesar.decryptCaesar("KHOOR"), "The decrypted output of \"KHOOR\" should be: " + "HELLO");
        assertEquals("HELLO WORLD", Caesar.decryptCaesar("KHOOR ZRUOG"), "The decrypted output of \"KHOOR ZRUOG\" should be: " + "HELLO WORLD");
        assertEquals("HELLO, WORLD!", Caesar.decryptCaesar("KHOOR, ZRUOG!"), "The decrypted output of \"KHOOR, ZRUOG!\" should be: " + "HELLO, WORLD!");

        // Lowercase, basic
        assertEquals("hello", Caesar.decryptCaesar("khoor"), "The decrypted output of \"khoor\" should be: " + "hello");
        assertEquals("hello world", Caesar.decryptCaesar("khoor zruog"), "The decrypted output of \"khoor zruog\" should be: " + "hello world");
        assertEquals("hello, world!", Caesar.decryptCaesar("khoor, zruog!"), "The decrypted output of \"khoor, zruog!\" should be: " + "hello, world!");

        // XYZ
        assertEquals("zebra x-rays", Caesar.decryptCaesar("cheud a-udbv"), "The decrypted output of \"cheud a-udbv\" should be: " + "zebra x-rays");
        assertEquals("CONTEXTUALIZE YAKS", Caesar.decryptCaesar("FRQWHAWXDOLCH BDNV"), "The decrypted output of \"FRQWHAWXDOLCH BDNV\" should be: " + "CONTEXTUALIZE YAKS");
        assertEquals("abcdefghijklmnopqrstuvwxyz", Caesar.decryptCaesar("defghijklmnopqrstuvwxyzabc"), "The decrypted output of \"defghijklmnopqrstuvwxyzabc\" should be: " + "abcdefghijklmnopqrstuvwxyz");
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Caesar.decryptCaesar("DEFGHIJKLMNOPQRSTUVWXYZABC"), "The decrypted output of \"DEFGHIJKLMNOPQRSTUVWXYZABC\" should be: " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals("abCDeFGhijKLMNOpqrSTuvWXyZ", Caesar.decryptCaesar("deFGhIJklmNOPQRstuVWxyZAbC"), "The decrypted output of \"deFGhIJklmNOPQRstuVWxyZAbC\" should be: " + "abCDeFGhijKLMNOpqrSTuvWXyZ");
    }

    @Test
    public void testEncryptCaesarKey() {
        // Uppercase, basic
        assertEquals("KHOOR, ZRUOG!", Caesar.encryptCaesarKey("HELLO, WORLD!", 3), "The encrypted output of \"HELLO, WORLD!\" with the key " + "3" + " should be: " + "KHOOR, ZRUOG!");
        assertEquals("KHOOR, ZRUOG!", Caesar.encryptCaesarKey("HELLO, WORLD!", 133), "The encrypted output of \"HELLO, WORLD!\" with the key " + "133" + " should be: " + "KHOOR, ZRUOG!");
        assertEquals("LIPPS, ASVPH!", Caesar.encryptCaesarKey("HELLO, WORLD!", 4), "The encrypted output of \"HELLO, WORLD!\" with the key " + "4" + " should be: " + "LIPPS, ASVPH!");
        assertEquals("MJQQT, BTWQI!", Caesar.encryptCaesarKey("HELLO, WORLD!", 5), "The encrypted output of \"HELLO, WORLD!\" with the key " + "5" + " should be: " + "MJQQT, BTWQI!");
    }

    @Test
    public void testDecryptCaesarKey() {
        // Uppercase, basic
        assertEquals("HELLO, WORLD!", Caesar.decryptCaesarKey("KHOOR, ZRUOG!", 3), "The decrypted output of \"KHOOR, ZRUOG!\" with the key " + "3" + " should be: " + "HELLO, WORLD!");
        assertEquals("HELLO, WORLD!", Caesar.decryptCaesarKey("KHOOR, ZRUOG!", 133), "The decrypted output of \"KHOOR, ZRUOG!\" with the key " + "133" + " should be: " + "HELLO, WORLD!");
        assertEquals("HELLO, WORLD!", Caesar.decryptCaesarKey("LIPPS, ASVPH!", 4), "The decrypted output of \"LIPPS, ASVPH!\" with the key " + "4" + " should be: " + "HELLO, WORLD!");
        assertEquals("HELLO, WORLD!", Caesar.decryptCaesarKey("MJQQT, BTWQI!", 5), "The decrypted output of \"MJQQT, BTWQI!\" with the key " + "5" + " should be: " + "HELLO, WORLD!");
    }

    @Test
    public void testEncryptVigenere() {
        // Basic tests
        assertEquals("HFNOS", Vigenere.encryptVigenere("HELLO", "ABCDE"), "The encrypted output of \"HELLO\" with the key \"ABCDE\" should be: " + "HFNOS");
        assertEquals("HFNOS WPTOH", Vigenere.encryptVigenere("HELLO WORLD", "ABCDE"), "The encrypted output of \"HELLO WORLD\" with the key \"ABCDE\" should be: " + "HFNOS WPTOH");      
        assertEquals("HFNOS, WPTOH!", Vigenere.encryptVigenere("HELLO, WORLD!", "ABCDE"), "The encrypted output of \"HELLO, WORLD!\" with the key \"ABCDE\" should be: " + "HFNOS, WPTOH!");    
        
        // Harder tests
        assertEquals("B qlsdk wyy jlwqs fffr krf lrjz dfq", Vigenere.encryptVigenere("A quick fox jumps over the lazy dog", "BARK"), "The encrypted output of \"A quick fox jumps over the lazy dog\" with the key \"BARK\" should be: " + "B qlsdk wyy jlwqs fffr krf lrjz dfq");
        assertEquals("Wenv af fzi kpxs qwci oznlr wtebsc uinw", Vigenere.encryptVigenere("Pack my box with five dozen liquor jugs", "HELLO"), "The encrypted output of \"Pack my box with five dozen liquor jugs\" with the key \"HELLO\" should be: " + "Wenv af fzi kpxs qwci oznlr wtebsc uinw");      
        assertEquals("Hfe uskinxtx ehicb lztg zeszzg wumg!", Vigenere.encryptVigenere("How vexingly quick daft zebras jump!", "ARIZONA"), "The encrypted output of \"How vexingly quick daft zebras jump!\" with the key \"ARIZONA\" should be: " + "Hfe uskinxtx ehicb lztg zeszzg wumg!");    
    }

    @Test
    public void testDecryptVigenere() {
        // Basic tests
        assertEquals("HELLO", Vigenere.decryptVigenere("HFNOS", "ABCDE"), "The decrypted output of \"HFNOS\" with the key \"ABCDE\" should be: " + "HELLO");
        assertEquals("HELLO WORLD", Vigenere.decryptVigenere("HFNOS WPTOH", "ABCDE"), "The decrypted output of \"HFNOS WPTOH\" with the key \"ABCDE\" should be: " + "HELLO WORLD");
        assertEquals("HELLO, WORLD!", Vigenere.decryptVigenere("HFNOS, WPTOH!", "ABCDE"), "The decrypted output of \"HFNOS, WPTOH!\" with the key \"ABCDE\" should be: " + "HELLO, WORLD!");

        // Harder tests
        assertEquals("A quick fox jumps over the lazy dog", Vigenere.decryptVigenere("B qlsdk wyy jlwqs fffr krf lrjz dfq", "BARK"), "The decrypted output of \"B qlsdk wyy jlwqs fffr krf lrjz dfq\" with the key \"BARK\" should be: " + "A quick fox jumps over the lazy dog");
        assertEquals("Pack my box with five dozen liquor jugs", Vigenere.decryptVigenere("Wenv af fzi kpxs qwci oznlr wtebsc uinw", "HELLO"), "The decrypted output of \"Wenv af fzi kpxs qwci oznlr wtebsc uinw\" with the key \"HELLO\" should be: " + "Pack my box with five dozen liquor jugs");
        assertEquals("How vexingly quick daft zebras jump!", Vigenere.decryptVigenere("Hfe uskinxtx ehicb lztg zeszzg wumg!", "ARIZONA"), "The decrypted output of \"Hfe uskinxtx ehicb lztg zeszzg wumg!\" with the key \"ARIZONA\" should be: " + "How vexingly quick daft zebras jump!");
    }
}
