class RecentCounter {
    private List<Integer> pings;
    private int left;

    public RecentCounter() {
        pings = new ArrayList<>();
        left = 0;
    }

    public int ping(int t) {
        pings.add(t);

        while (pings.get(left) < t - 3000) {
            left++;
        }

        return pings.size() - left;
    }
}