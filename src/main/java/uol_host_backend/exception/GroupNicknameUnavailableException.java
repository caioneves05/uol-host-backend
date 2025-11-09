package uol_host_backend.exception;

public class GroupNicknameUnavailableException extends IllegalArgumentException {
   public GroupNicknameUnavailableException() {
       super("There are no available nicknames for this group.");
   }
}
