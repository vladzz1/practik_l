package org.example;
import lombok.ToString;

@ToString
public class Matrix {
    private final int countOneLine;
    private int countRows;
    private int[][] matrix;

    public Matrix(int countOneLine) {
        this.countOneLine = countOneLine;
        this.countRows = 0;
        this.matrix = null;
    }

    public void addOneLine(int[] line) {
        if (line == null || line.length < countOneLine) return;
        if (matrix == null) {
            matrix = new int[1][countOneLine];
            for (int i = 0; i < countOneLine; i++) {
                matrix[0][i] = line[i];
            }
            countRows++;
            return;
        }
        int[][] newMatrix = new int[countRows + 1][countOneLine];
        for (short i = 0; i < countRows; i++) {
            for (short j = 0; j < countOneLine; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < countOneLine; i++) {
            newMatrix[countRows][i] = line[i];
        }
        matrix = newMatrix;
        countRows++;
    }

    public int[][] addition(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;

        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Матриці повинні бути однакового розміру!");
        }

        int[][] result = new int[rows1][cols1];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] subtraction(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;

        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Матриці повинні бути однакового розміру!");
        }

        int[][] result = new int[rows1][cols1];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] multiplication(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1.length;

        int rows2 = matrix2.length;
        int cols2 = matrix2.length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Кількість стовпців першої матриці повинна дорівнювати кількості рядків другої матриці!");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                int sum = 0;
                for (int k = 0; i < cols1; i++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }

                result[i][j] = sum;
            }
        }

        return result;
    }

    public int[][] division(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1.length;

        int rows2 = matrix2.length;
        int cols2 = matrix2.length;

        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Для поелементного ділення матриці повинні бути однакового розміру!");
        }

        int[][] result = new int[rows1][cols1];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                if (matrix2[i][j] == 0) {
                    throw new ArithmeticException("Помилка: ділення на нуль у матриці 2 на позиції [" + i + "][" + j + "]!");
                }

                result[i][j] = matrix1[i][j] / matrix2[i][j];
            }
        }

        return result;
    }

    public int min(int[][] matrix) {
        int minValue = matrix[0][0];
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell < minValue) {
                    minValue = cell;
                }
            }
        }
        return minValue;
    }

    public int max(int[][] matrix) {
        int maxValue = matrix[0][0];
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell > maxValue) {
                    maxValue = cell;
                }
            }
        }
        return maxValue;
    }

    public double avg(int[][] matrix) {
        long sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                sum += cell;
                count++;
            }
        }

        return (double) sum / count;
    }
}
