class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = players.length, t = trainers.length, p_start = 0, t_start = 0;
        while (p_start < p && t_start < t) {
            if (players[p_start] <= trainers[t_start]) {
                p_start++;
                t_start++;
            } else {
                t_start++;
            }
        }
        return p_start;
    }
}