package org.gqdemo.entities;

import lombok.Data;

import java.util.Map;

/**
 * @version v1.0
 * @ClassName GraphqlRequest
 * @Description TODO
 * @Author Q
 */
@Data
public class GraphqlRequest {

    private String query;

    private Map<String, Object> variables;
}
