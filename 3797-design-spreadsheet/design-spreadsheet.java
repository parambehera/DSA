class Spreadsheet {
    int grid[][];
    public Spreadsheet(int rows) {
        grid = new int[rows+1][26];
    }
    
    public void setCell(String cell, int value) {
        int col =cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        grid[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col =cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        grid[row][col] = 0;
    }
    
    public int getValue(String formula) {
        int len = formula.length();
        String val = formula.substring(1,len);
        String [] sp = val.split("\\+");
        int sum =0;
        int i =1;
        if(sp[0].charAt(0)>='A' && sp[0].charAt(0)<='Z'){
             int col =sp[0].charAt(0)-'A';
             int row = Integer.parseInt(sp[0].substring(1,sp[0].length()));
             sum+=grid[row][col];
        }
        else{
            sum+=Integer.parseInt(sp[0]);
        }
          if(sp[1].charAt(0)>='A' && sp[1].charAt(0)<='Z'){
             int col =sp[1].charAt(0)-'A';
             int row = Integer.parseInt(sp[1].substring(1,sp[1].length()));
             sum+=grid[row][col];
        }
        else{
            sum+=Integer.parseInt(sp[1]);
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */