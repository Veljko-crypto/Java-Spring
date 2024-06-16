# Java-Spring Application
Build a web application using Spring framework and Java 21.

**Some of the key requirements are the following:**
1. Application has an endpoint that accepts a collection of elements.
2. Each element represens a string value and list of transformers that will be applied to the value.
3. Each transformer is identified by groupId and transformerId and may have optional parameters.
4. Application has three transformers that can be applied to incoming elements values.
  - 1st transformer should accept regex as parameter, find matches in element value and remove it from
    original value.
  - 2nd transformer should accept regex and "replacement" as parameters, find matches in original values and
    replace them with value given in parameter.
  - 3rd transformer should detect Cyrillic and Greek letters in given value and convert those letters to Latin.
5. Transformers should be applied in a given order and produce response with original and transformed values.

**HOW-TO-USE**

**transformerId** is a unique integer value that has a value of 1, 2 or 3. This value represents the transformer 1, transformer 2 and transformer 3, respectively.

**groupId** is an integer that represents the group that each transformer belongs to. String "value" will be modified grouped by all the transformers with the same groupId, then applied all the transformers with the increasing transformerId.

For testing purposes, I've used Swagger on the following path: http://localhost:8080/swagger-ui/index.html#/

Here you will be able to see the responses for the given requests.
