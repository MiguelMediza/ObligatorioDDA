package Persistencia;

import Utils.AppSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    public Conexion() {
    }
    protected static String getCadenaDeConexion() {
        return "jdbc:mysql://localhost:3306/obligatorio?user=root&password=RootPassword2024.";
    }

    public boolean consulta(String sql, List<Object> parametros) throws AppSQLException {
        try {
            Connection conexion = DriverManager.getConnection(getCadenaDeConexion());

            boolean var13;
            try {
                PreparedStatement comando = conexion.prepareStatement(sql);

                try {
                    if (parametros != null) {
                        for(int i = 0; i < parametros.size(); ++i) {
                            comando.setObject(i + 1, parametros.get(i));
                        }
                    }

                    comando.executeUpdate();
                    var13 = true;
                } catch (Throwable var9) {
                    if (comando != null) {
                        try {
                            comando.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (comando != null) {
                    comando.close();
                }
            } catch (Throwable var10) {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (conexion != null) {
                conexion.close();
            }

            return var13;
        } catch (SQLException var11) {
            SQLException e = var11;
            throw new AppSQLException("Error ejecutando consulta", e);
        }
    }

    public List<List<Object>> seleccion(String sql, List<Object> parametros) throws AppSQLException {
        List<List<Object>> resultado = new ArrayList();

        try {
            Connection conexion = DriverManager.getConnection(getCadenaDeConexion());

            try {
                PreparedStatement comando = conexion.prepareStatement(sql);

                try {
                    if (parametros != null) {
                        for(int i = 0; i < parametros.size(); ++i) {
                            comando.setObject(i + 1, parametros.get(i));
                        }
                    }

                    ResultSet resultSet = comando.executeQuery();

                    try {
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        while(resultSet.next()) {
                            List<Object> fila = new ArrayList();

                            for(int i = 1; i <= columnCount; ++i) {
                                fila.add(resultSet.getObject(i));
                            }

                            resultado.add(fila);
                        }
                    } catch (Throwable var14) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var13) {
                                var14.addSuppressed(var13);
                            }
                        }

                        throw var14;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var15) {
                    if (comando != null) {
                        try {
                            comando.close();
                        } catch (Throwable var12) {
                            var15.addSuppressed(var12);
                        }
                    }

                    throw var15;
                }

                if (comando != null) {
                    comando.close();
                }
            } catch (Throwable var16) {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Throwable var11) {
                        var16.addSuppressed(var11);
                    }
                }

                throw var16;
            }

            if (conexion != null) {
                conexion.close();
            }

            return resultado;
        } catch (SQLException var17) {
            SQLException e = var17;
            throw new AppSQLException("Error ejecutando consulta", e);
        }
    }
}
