class Solution {
    public long solution(String block, int pos) {
        long answer = 1;
        // 0번 인덱스부터 시작하도록
        pos -= 1;
        StringBuilder sb = new StringBuilder(block);
        
        while(true){
            // 오른쪽으로 이동
            if(sb.charAt(pos) == '>'){
                // 방향 전환
                sb.setCharAt(pos, '<');
                pos++;
            }else if(sb.charAt(pos) =='<'){ // 왼쪽으로 이동
                sb.setCharAt(pos, '>'); //방향전환
                pos--;
            }
            answer++; // 1초 경과
            // 인덱스가 마지막에 도착한 후 >를 만나면 탈출
            if(pos == block.length()-1 && sb.charAt(pos) == '>')
                break;
            // 인덱스가 시작점에 도착한 후 <를 만나면 탈출
            if(pos == 0 && sb.charAt(pos) == '<')
                break;
            
        }
        return answer;
    }
}