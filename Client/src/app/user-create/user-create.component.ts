import {Component} from '@angular/core';
import {UserService} from '../user-service/user.service';

@Component({
    templateUrl: '/user-list.component.html'
})
export class UserListComponent {

    user: any = [];

    constructor(private userService: UserService) {

        userService.createUser(this.user)
            .subscribe(
                users => this.user = users,
                error => console.log(error)
            );
    }

}

