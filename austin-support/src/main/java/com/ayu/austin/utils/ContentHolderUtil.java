package com.ayu.austin.utils;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.PropertyPlaceholderHelper;

import java.text.MessageFormat;
import java.util.Map;

/**
 * @Author: aYu
 * @Date: 2022/7/27 20:45
 * @Description: 内容占位符替换
 * austin占位符格式{$var}
 */
public class ContentHolderUtil {

    // 占位符前缀
    private static final String PLACE_HOLDER_PREFIX = "{$";
    // 占位符后缀
    private static final String PLACE_HOLDER_ENDFIX = "}";

    private static final StandardEvaluationContext EVALUTIONCONTEXT;

    private static PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper(
            PLACE_HOLDER_PREFIX, PLACE_HOLDER_ENDFIX);

    static {
        EVALUTIONCONTEXT = new StandardEvaluationContext();
        EVALUTIONCONTEXT.addPropertyAccessor(new MapAccessor());
    }

    public static String replacePlaceHolder(final String template, final Map<String, String> paramMap) {
        String replacedPushContent = propertyPlaceholderHelper.replacePlaceholders(template,
                new CustomPlaceholderResolver(paramMap));
        return replacedPushContent;
    }

    private static class CustomPlaceholderResolver implements PropertyPlaceholderHelper.PlaceholderResolver {
        private Map<String, String> paramMap;

        public CustomPlaceholderResolver(Map<String, String> paramMap) {
            super();
            this.paramMap = paramMap;
        }

        @Override
        public String resolvePlaceholder(String placeholderName) {
            String value = paramMap.get(placeholderName);
            if (null == value) {
                String errorStr = MessageFormat.format("template:{} require param:{},but not exist! paramMap:{}",
                        placeholderName, paramMap.toString());
                throw new IllegalArgumentException(errorStr);
            }
            return value;
        }
    }

}
