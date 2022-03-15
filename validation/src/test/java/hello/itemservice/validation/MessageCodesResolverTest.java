package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    public void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    public void messageCodesResolverField() {
        String[] messageCodes = codesResolver
            .resolveMessageCodes("required", "item", "itemName", String.class);
        //bindingResult.rejectValue("itemName", "required");
        assertThat(messageCodes).containsExactly("required.item.itemName", "required.itemName",
            "required.java.lang.String", "required");
    }
}
