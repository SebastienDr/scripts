package bills;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Splitter.*;
import static com.google.common.collect.Lists.*;
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

    @Test
    public void should_extract_file_name_remove_extension() {
        // Given
        // When
        String fileNameWithExtension = "07_09_15_Facture_Tablet_Xperia.pdf";
        String result = newArrayList(on(".").split(fileNameWithExtension)).get(0);
        // Then
        assertThat(result).isNotNull();
        System.out.println(result);
    }

}