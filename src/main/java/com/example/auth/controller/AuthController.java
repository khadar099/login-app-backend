@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {


@Autowired
private UserService userService;


@Autowired
private JwtService jwtService;


@PostMapping("/register")
public User register(@RequestBody User user) {
return userService.register(user);
}


@PostMapping("/login")
public Map<String, String> login(@RequestBody User user) {
User u = userService.login(user.getUsername(), user.getPassword());
Map<String, String> res = new HashMap<>();


if(u != null) {
res.put("token", jwtService.generateToken(user.getUsername()));
return res;
}
res.put("error", "Invalid Credentials");
return res;
}
}
