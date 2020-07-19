package com.car.rent;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.nio.file.Paths;

/**
 * @author nayix
 * @date 2020/7/4 13:11
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerExportTest {
    @Test
    public void generateAsciiDocs() throws Exception {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                // 设置生成格式
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                // 设置语言
                .withOutputLanguage(Language.ZH)
                // 设置分组方式
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/main/resources/docs/ascii-doc"));
    }
}
