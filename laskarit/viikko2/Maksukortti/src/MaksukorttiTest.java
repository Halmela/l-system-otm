import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaksukorttiTest {

    Maksukortti kortti;
    String kortti1;
    String kortti2;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        kortti1 = "Kortilla on rahaa ";
        kortti2 = ".0 euroa";
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }


    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }


    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }


    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }


    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }


    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }


    @Test
    public void maukasEiTeeSaldostaNegatiivista() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }


    @Test
    public void negatiivinenLatausEiVaikutaSaldoon() {
        kortti.lataaRahaa(-10);
        assertEquals(kortti1 + 10+kortti2, kortti.toString());
    }


    @Test
    public void edullisenOstoOnnistuuTukiaEdeltavanaPaivana() {
        Maksukortti kort = new Maksukortti(2.5);
        kort.syoEdullisesti();
        assertEquals(kortti1+0+kortti2, kort.toString());
    }


    @Test
    public void maukkaanOstoOnnistuuTukiaEdeltavanaPaivana() {
        Maksukortti kort = new Maksukortti(4);
        kort.syoMaukkaasti();
        assertEquals(kortti1+0+kortti2, kort.toString());
    }
}