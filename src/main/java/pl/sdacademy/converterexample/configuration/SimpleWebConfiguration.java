package pl.sdacademy.converterexample.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SimpleWebConfiguration {
//    @Bean
//    public ObjectMapper objectMapper() {
//        final ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        return objectMapper;
//    }

//    @Bean
//    @Primary
//    public ObjectMapper objectMapper() {
//        JavaTimeModule module = new JavaTimeModule();
//        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
//        return new ObjectMapper()
//                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//                .registerModule(module);
//    }

    @Bean
    public Converter<String, Map<String, String>> skillsConverter() {
        return new Converter<String, Map<String, String>>() {
            @Override
            public Map<String, String> convert(final String value) {
                Map<String, String> map = new HashMap<>();
                if(value != null) {
                    final String[] splitMap = value.split(",");
                    map.put(splitMap[0], splitMap[1]);
                }
                return map;
            }

            @Override
            public JavaType getInputType(TypeFactory typeFactory) {
                return typeFactory.constructType(String.class);
            }

            @Override
            public JavaType getOutputType(final TypeFactory typeFactory) {
                return typeFactory.constructMapLikeType(Map.class, String.class, String.class);
            }
        };
    }
}
