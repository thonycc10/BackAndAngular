package com.thony.spring.boot.backend.apirest.springbootbackendapirest.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAud+36QfMK0hFBrv+Weoo\n" +
            "K8j8Fpn65tVnjufQQ4uX/h1r6tQ+Gy5i3tjb8XpoTUVJd3bGio6+JD0yWBobkZbR\n" +
            "C2ZlG35Ax7FT86H2bwENA0/ODWU23fdkq+vHrFOlNp8llTnhiXsnIp7d2uUMY0GD\n" +
            "xiQIENgbKReMrJj39sKZwKxQl81anNLvHJjLYgjmNNTJZA5km82KHZsv0CM49U7m\n" +
            "Ne6do39gL/nq7m+idIqzw6qyzMfKKV/jXnyoNO3rmki3KGbSmwqc/+L1YHxmUS7A\n" +
            "PVpF5cFyTF08Lam3x5u5eQaxa2bkfT6ehcEkRQaHhys4TQQMng49ePC/dmqD54D+\n" +
            "cwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAud+36QfMK0hFBrv+WeooK8j8Fpn65tVnjufQQ4uX/h1r6tQ+\n" +
            "Gy5i3tjb8XpoTUVJd3bGio6+JD0yWBobkZbRC2ZlG35Ax7FT86H2bwENA0/ODWU2\n" +
            "3fdkq+vHrFOlNp8llTnhiXsnIp7d2uUMY0GDxiQIENgbKReMrJj39sKZwKxQl81a\n" +
            "nNLvHJjLYgjmNNTJZA5km82KHZsv0CM49U7mNe6do39gL/nq7m+idIqzw6qyzMfK\n" +
            "KV/jXnyoNO3rmki3KGbSmwqc/+L1YHxmUS7APVpF5cFyTF08Lam3x5u5eQaxa2bk\n" +
            "fT6ehcEkRQaHhys4TQQMng49ePC/dmqD54D+cwIDAQABAoIBAHBYpJSZPfK7T91u\n" +
            "K6K1QWqVpKkUkO6M9ncN7nelHE1gAyaA+rj7JI+FjAs87WYnBuzKQd7lwE+vHYra\n" +
            "3Ob2vYuibGJdwVHyAMg1kPovLGpgBi9aiftH2PWBIcMrG6UUNGcqAQRUB6eJVpdD\n" +
            "8mTb6IYOqUFlHaWMsl5wZxAjN0OY23mr4rHAdb6BIgVYlQArBUygUyrFpojDsMF2\n" +
            "qxEy6kocMPQ6PKDF1HiJkBsUNalfGAVBhvkr1IeVCbv+MiE0oqcdJD/AKwV3FJss\n" +
            "GVji3mMcjZXw87KMsvBj75A/x2fk76JntyoN9rvCK+n5sdrw2PH7fXEq3HkARIBT\n" +
            "YGMA50ECgYEA4/QdjvL5YMGiykTahyZRbletwEZLLUqnEBGPGcZAXuAdVqbxDol7\n" +
            "GRkCEx1MhwhIEvQy1ge+8R5dB+Fz04dTVv2x6UHRbxUldd1V8e8Vta9qTxSedUCN\n" +
            "SIch0wXa+RacIzJ5NTp/ImodhEMI9ZG/ord5Aijg9nlp/ptt63waorkCgYEA0L42\n" +
            "tVFeQFGO/Fdn85255Cm7xGUQ68n4EcBxjlEqvDGBytKa+vQOv6U0AxIJ0noONnND\n" +
            "Q4cF6IjOQ/Rl9+tqMjSvuDnw9dYLyWETCY+/tKpaq+lDzu5+uBVVnToDz4JdlN7K\n" +
            "hHdfcbRv5ljC1p050oWdwrEY0ZxbrSChIX2dxIsCgYBVX5sma6esbjkq6iiyD07W\n" +
            "Na5UYb9MIjZ5lSn0LET1g5hZWMLVf/YDi1M0l3eO5zIfLyhO8q23nniXN//qTDeR\n" +
            "UAiu5MCsis3x28iRiMqnth/pqD5Eib2gWUP4xauiOK6XnBK7NcJhwD53x6d2WXTd\n" +
            "WzvN7EN87DIfclTzqhJLuQKBgHAinrUMvvsCVTONqNQgGOpO2QWJ3WstFkxC+z2e\n" +
            "sLxkQ/s24/aIARxGnQhBOnGNC/GIPcwazru6MkQjGFv0ZRoPX44x4hXOJIrL0TRD\n" +
            "upJNKWRMbRbO29f77gAGWGGzAJ6miFhc4DLu4WX2rMQpthQ3nyYliNWhj0YTzzt0\n" +
            "hbo9AoGBAMhOAOYVg21mMPz2P5iSmDhiRuPt03myUVC1U3e2mSU+bgwOIkNn8KNC\n" +
            "rQApuFcbDK5qUyPTBDK2xwkDKEmS+NTX+mboABgauK1yAgylAFSnwQQEUZx/Qmjp\n" +
            "4O5VHWR6V5C1SNh6WnRFLaOgxzMEqINJ0JEkRc/s0x742bW9qyNX\n" +
            "-----END RSA PRIVATE KEY-----";
}
