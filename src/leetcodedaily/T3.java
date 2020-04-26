package leetcodedaily;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

public class T3 {
        public static int minimalSteps(String[] maze) {

            List<int[]> ms = new ArrayList<>();
            for(int i=0; i<maze.length; i++) {
                for (int j = 0; j < maze[i].length(); j++) {
                    if (maze[i].charAt(j) == 'M') {
                        ms.add(new int[]{i, j});
                    }
                }
            }

            int res=0;
            for (int i = 0; i < ms.size(); i++) {
                int[] ints = ms.get(i);
                res += bfs(maze, ints[0], ints[1]);
            }

            // plus s->m->m->e; min;



            return res;
        }

        public static void main(String[] args) {
            System.out.println(minimalSteps(new String[]{
                    "S.O", "M..", "M.."
            }));
        }

        static int [][] dir = new int[][]{
                {0,1},{0,-1},{1,0},{-1,0}
        };
        static int bfs(String[] maze, int i, int j) {
            LinkedList<int[]> stack = new LinkedList<>();
            boolean[][] flag = new boolean[maze.length][maze[0].length()];
            flag[i][j] = true;
            stack.push(new int[]{i, j});
            int c=-1;
            while (!stack.isEmpty()) {
                c++;
                int size = stack.size();
                for (int u = 0; u < size; u++) {
                    int[] pop = stack.removeFirst();
                    if (maze[pop[0]].charAt(pop[1]) == 'O') {
                        break;
                    }
                    for (int k = 0; k < dir.length; k++) {
                        if (pop[0] + dir[k][0] >=0 && pop[0] + dir[k][0] < maze.length &&
                                pop[1] + dir[k][1] >=0 && pop[1] + dir[k][1] < maze[0].length() &&
                                !flag[pop[0] + dir[k][0]][pop[1] + dir[k][1]] && maze[pop[0] + dir[k][0]].charAt(pop[1] + dir[k][1]) != '#') {
                            flag[pop[0] + dir[k][0]][pop[1] + dir[k][1]] = true;
                            stack.addLast(new int[]{pop[0] + dir[k][0], pop[1] + dir[k][1]});
                        }
                    }
                }

            }
            return c;
        }
    }
