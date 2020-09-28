import classes from '../../../css/UsersSearch.module.css';
import React from 'react';
import styled from 'styled-components';
import { generateMediaUrl, placeholder } from '../../../utilities';


const Avatar = styled.img`
width: 40px;
height: 40px;
`;

const UserListItem = ({ user }) => {
    return (
        <div className={classes.item}>
            <Avatar src={user.avatarId ? generateMediaUrl(user.avatarId) : placeholder} small />
            <div>
                {user.name} <div className={classes.username}>({user.username})</div>
            </div>
        </div>
    )
}

export default UserListItem;