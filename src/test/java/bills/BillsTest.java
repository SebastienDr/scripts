package bills;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class BillsTest {

    Bills bills = new Bills();

    @Test
    public void should_filter_by_universal_pattern_return_all_files() throws IOException {
        bills.filterFilesByPattern();
    }

    @Test
    public void should_filter_by_september_return_only_3_files() throws IOException {
        bills.filterFilesBySeptember();
    }

    @Test
    public void should_match_universal_return_true() {
        boolean result = bills.matcher("test");
        assertThat(result).isTrue();
    }

    @Test
    public void should_match_universal_with_filename_return_true() {
        boolean result = bills.matcher("07_09_15_Facture_Tablet_Xperia.pdf");
        assertThat(result).isTrue();
    }

    @Test
    public void should_match_universal_with_accents_return_false() {
        boolean result = bills.matcher("é");
        assertThat(result).isFalse();
    }

}