class Entry {
  int ts;
  String val;

  Entry(int ts, String val) {
    this.ts = ts;
    this.val = val;
  }
}

class TimeMap {

  Map<String, List<Entry>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    Entry entry = new Entry(timestamp, value);

    map.putIfAbsent(key, new ArrayList<>());
    map.get(key).add(entry);
  }

  public String get(String key, int timestamp) {
    List<Entry> ts_val_pairs = map.get(key);
    if(ts_val_pairs == null) return "";

    int l = 0;
    int r = ts_val_pairs.size() - 1;
    int max = 0;
    String res_val = "";
    while(l <= r) {
      int m = l + (r - l) / 2;
      Entry cur_entry = ts_val_pairs.get(m);
      int cur_ts = cur_entry.ts;
      if(cur_ts <= timestamp) {
        if(cur_ts > max) {
          max = cur_ts;
          res_val = cur_entry.val;
        }
      }

      if(cur_ts < timestamp) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return res_val;
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */