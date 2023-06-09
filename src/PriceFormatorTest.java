import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PriceFormatorTest {

    @Test
    void PriceFormatForCountryCZ()throws Exception{
        assertEquals("200 Kč",PriceFormator.formatForCountry(200,"CZ"));
    }
    @Test
    void PriceFormatForCountrySK()throws Exception{
        assertEquals("200 €",PriceFormator.formatForCountry(200,"SK"));
    }
    @Test
    void PriceFormatForCountryUS() throws Exception {
        assertEquals("$200",PriceFormator.formatForCountry(200,"US"));
    }

    @Test
    void PriceFormatForCountryCZDec()throws Exception{
        assertEquals("200 Kč",PriceFormator.formatForCountry(200.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDec()throws Exception{
        assertEquals("200.12 €",PriceFormator.formatForCountry(200.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDec()throws Exception{
        assertEquals("$200.12",PriceFormator.formatForCountry(200.1234,"US"));
    }
    @Test
    void PriceFormatForCountryCZDecNeg()throws Exception{
        assertEquals("-200 Kč",PriceFormator.formatForCountry(-200.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDecNeg()throws Exception{
        assertEquals("-200.12 €",PriceFormator.formatForCountry(-200.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDecNeg()throws Exception{
        assertEquals("-$200.12",PriceFormator.formatForCountry(-200.1234,"US"));
    }
    @Test
    void PriceFormatForCountryCZDecThousands()throws Exception{
        assertEquals("200 000 Kč",PriceFormator.formatForCountry(200000.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDecThousands()throws Exception{
        assertEquals("200 000.12 €",PriceFormator.formatForCountry(200000.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDecThousands()throws Exception{
        assertEquals("$200 000.12",PriceFormator.formatForCountry(200000.1234,"US"));
    }
    @Test
    void PriceFormatForCountryCZDecThousandsNeg()throws Exception{
        assertEquals("-200 000 Kč",PriceFormator.formatForCountry(-200000.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDecThousandsNeg()throws Exception{
        assertEquals("-200 000.12 €",PriceFormator.formatForCountry(-200000.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDecThousandsNeg()throws Exception{
        assertEquals("-$200 000.12",PriceFormator.formatForCountry(-200000.1234,"US"));
    }
    @Test
     void InvalidCountryShortCut()throws Exception{
        Throwable exception = assertThrows(java.lang.Exception.class, () -> PriceFormator.formatForCountry(-200000.1234,"XX"));
        assertEquals("Country not found!", exception.getMessage());
    }
    @Test
    void PriceFormatForCountryCZZero()throws Exception{
        assertEquals("0 Kč",PriceFormator.formatForCountry(0,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKZero()throws Exception{
        assertEquals("0 €",PriceFormator.formatForCountry(0,"SK"));
    }
    @Test
    void PriceFormatForCountryUSZero()throws Exception{
        assertEquals("$0",PriceFormator.formatForCountry(0,"US"));
    }

    @Test
    void PriceFormatForCountryHU()throws Exception{
        assertEquals("-1 200 212.021 Ft",PriceFormator.formatForCountry(-1200212.0214,"HU"));
    }
    @Test
    void PriceFormatorForVATOfCZ()throws Exception{
        assertEquals("420 Kč", PriceFormator.formatForCountryOfVAT(2000,"CZ"));
    }
    @Test
    void PriceFormatorForVATOfSK()throws Exception{
        assertEquals("400 €", PriceFormator.formatForCountryOfVAT2(2000,"SK"));
    }
    @Test
    void PriceFormatorForVATUS()throws Exception{
        assertEquals("$120", PriceFormator.formatForCountryOfVAT(2000,"US"));
    }
    @Test
    void PriceFormatorForVATHU()throws Exception{
        assertEquals("540 Ft", PriceFormator.formatForCountryOfVAT(2000,"HU"));
    }
}
