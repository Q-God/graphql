package org.gqdemo.graphql;

import graphql.GraphQL;
import graphql.kickstart.tools.SchemaParser;
import graphql.scalar.GraphqlLongCoercing;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;

import java.io.IOException;
import javax.annotation.PostConstruct;

import org.gqdemo.graphql.resolver.ItemResolver;
import org.gqdemo.graphql.resolver.Mutation;
import org.gqdemo.graphql.resolver.Query;
import org.gqdemo.graphql.scaler.GraphQLScalarDateType;
import org.gqdemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @version v1.0
 * @ClassName Query
 * @Description TODO
 * @Author Q
 */
@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @Autowired
    private ItemService itemService;


    @PostConstruct
    public void init() throws IOException {
        GraphQLSchema graphQLSchema = SchemaParser.newParser()
                .file("base.graphqls")
                .resolvers(new Query(), new Mutation())
                .file("item.graphqls")
                .resolvers(new ItemResolver(itemService))//其它定义照上面的示例，继续增加
                .scalars(new GraphQLScalarType("Long", "long type", new GraphqlLongCoercing()))
                .scalars(new GraphQLScalarDateType())
                .build().makeExecutableSchema();

        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

}