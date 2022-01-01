package cn.datawisher.spring5.conditional;

/**
 * @author h407644
 * @date 2022-01-01
 */
public class LinuxListService implements ListService{
    @Override
    public String showListCmd() {
        return "ls";
    }
}
